/*
 * Copyright 2007-2012 The Europeana Foundation
 *
 *  Licenced under the EUPL, Version 1.1 (the "Licence") and subsequent versions as approved
 *  by the European Commission;
 *  You may not use this work except in compliance with the Licence.
 * 
 *  You may obtain a copy of the Licence at:
 *  http://joinup.ec.europa.eu/software/page/eupl
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under
 *  the Licence is distributed on an "AS IS" basis, without warranties or conditions of
 *  any kind, either express or implied.
 *  See the Licence for the specific language governing permissions and limitations under
 *  the Licence.
 */

package eu.europeana.corelib.solr.entity;

import org.bson.types.ObjectId;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.support.index.IndexType;

import com.google.code.morphia.annotations.Id;

import eu.europeana.corelib.definitions.solr.entity.AbstractEdmEntity;

/**
 * @see AbstractEdmEntity
 * 
 * @author Yorgos.Mamakis@ kb.nl
 */
@NodeEntity
public class AbstractEdmEntityImpl implements AbstractEdmEntity {

	@org.springframework.data.neo4j.annotation.Indexed(unique=true,indexType = IndexType.FULLTEXT, indexName = "edmsearch2")
	@com.google.code.morphia.annotations.Indexed(unique = true, dropDups=true)
	protected String about;

	@Id
	protected ObjectId id = new ObjectId();

	@GraphId
	protected Long neoID;
	@Override
	public ObjectId getId() {
		return this.id;
	}

	@Override
	public void setId(ObjectId id) {
		this.id = id;
	}

	@Override
	public String getAbout() {
		return this.about;
	}

	@Override
	public void setAbout(String about) {
		this.about = about;
	}
	
	public Long getNeoID() {
		return neoID;
	}

	public void setNeoID(Long neoID) {
		this.neoID = neoID;
	}
}
