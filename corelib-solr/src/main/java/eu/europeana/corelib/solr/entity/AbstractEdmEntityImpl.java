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

import com.google.code.morphia.annotations.Indexed;

import eu.europeana.corelib.definitions.solr.entity.AbstractEdmEntity;

/**
 * @see AbstractEdmEntity
 * 
 * @author Yorgos.Mamakis@ kb.nl
 */
public class AbstractEdmEntityImpl implements AbstractEdmEntity {

	@Indexed(unique=false)
	private String about;
	private ObjectId id;
	@Override
	public ObjectId getId() {
		
		return this.id;
	}

	@Override
	public void setId(ObjectId id) {
		this.id=id;

	}

	@Override
	public String getAbout() {
		return this.about;
	}

	@Override
	public void setAbout(String about) {
		this.about = about;
	}

}
