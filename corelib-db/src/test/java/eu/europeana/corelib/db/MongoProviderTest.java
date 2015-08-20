package eu.europeana.corelib.db;

import com.mongodb.Mongo;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import eu.europeana.corelib.edm.exceptions.MongoDBException;
import eu.europeana.corelib.mongo.server.EdmMongoServer;
import eu.europeana.corelib.mongo.server.impl.EdmMongoServerImpl;
import eu.europeana.corelib.storage.MongoProvider;

import java.io.IOException;

public class MongoProviderTest implements MongoProvider {

    private Mongo mongo;

    public MongoProviderTest() {
        int port = 10000;
        try {
            IMongodConfig conf = new MongodConfigBuilder()
                    .version(Version.Main.PRODUCTION)
                    .net(new Net(port, Network.localhostIsIPv6())).build();
            MongodStarter runtime = MongodStarter.getDefaultInstance();
            MongodExecutable mongodExecutable = runtime.prepare(conf);
            mongodExecutable.start();
            mongo = new Mongo("localhost", port);
            EdmMongoServer mongoDBServer = new EdmMongoServerImpl(mongo, "europeana_test", "",
                    "");
            mongoDBServer.getDatastore().getDB().dropDatabase();
        } catch (IOException | MongoDBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Mongo getMongo() {
        return mongo;
    }
}