/*******************************************************************************
 * Copyright  (c) 2015-2016, WSO2.Telco Inc. (http://www.wso2telco.com) All Rights Reserved.
 * 
 * WSO2.Telco Inc. licences this file to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.wso2telco.core.pcrservice.persistable;

import com.wso2telco.core.pcrservice.dao.SectorDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.wso2telco.core.pcrservice.exception.PCRException;
import com.wso2telco.core.pcrservice.model.SectorDTO;

// TODO: Auto-generated Javadoc
/**
 * The Class SectorService.
 */
public class SectorService {

	/** The log. */
	private static Logger log = LoggerFactory.getLogger(SectorService.class);

	/**
	 * Gets the sector.
	 *
	 * @param sectorID the sector ID
	 * @return the sector
	 * @throws PCRException the PCR exception
	 */
	public SectorDTO getSector(final String sectorID) throws PCRException{
		
		SectorDTO sectorDTO = new SectorDTO();
	
		if (isInvalidString(sectorID)) {
			 log.debug("sector ID cannot be null or empty");
			 throw new PCRException("sector ID null or empty");
		}
		sectorDTO.setSectorId(sectorID);
		try {
			SectorDAO sectorDAO = new SectorDAO();
			if(sectorDAO.checkSectorExist(sectorDTO)){
				return sectorDTO;
			}else{
				throw new PCRException("No sector found");
			}
		}catch(Exception e){
			log.error("getSector() failed ", e);
			throw new PCRException("getSector() failed");
		}

	}

	/**
	 * Creates the sector.
	 *
	 * @param sectorDTO the sector DTO
	 * @return the sector DTO
	 * @throws PCRException the PCR exception
	 */
	public SectorDTO createSector(final SectorDTO sectorDTO) throws PCRException{		
		return null;
	}

	/**
	 * Checks if is invalid string.
	 *
	 * @param str the str
	 * @return true, if is invalid string
	 */
	public static boolean isInvalidString(final String str) {
		if (str == null) {
			return true;
		}
		String as = str.trim();
		if ((as.equals("null")) || (as.equals(""))) {
			return true;
		}
		return false;
	}

}
