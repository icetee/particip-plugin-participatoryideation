/*
 * Copyright (c) 2002-2020, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.participatoryideation.business;

import fr.paris.lutece.plugins.participatoryideation.service.campaign.IIdeationCampaignService;
import fr.paris.lutece.plugins.participatoryideation.service.campaign.IdeationCampaignService;
import fr.paris.lutece.plugins.participatoryideation.util.Constants;
import fr.paris.lutece.test.LuteceTestCase;

/**
 * DepositaireTypeTest
 */
public class IdeationCampaignServiceTest extends LuteceTestCase
{
    public void testBusiness(  )
    {
    	// Initialize an object
    	IIdeationCampaignService instance = IdeationCampaignService.getInstance();

    	// Spring bean instantiation
    	assertTrue( instance.getClass() == IdeationCampaignService.class );
    	
    	// Methods about areas
    	assertEquals( 1, instance.getCampaignAllAreas(       ).size() );
    	assertEquals( 1, instance.getCampaignAllAreas( "123" ).size() );
    	
    	assertEquals( 0, instance.getCampaignLocalizedAreas(       ).size() );
    	assertEquals( 0, instance.getCampaignLocalizedAreas( "123" ).size() );
    	
    	assertEquals( 0, instance.getCampaignNumberLocalizedAreas(       ) );
    	assertEquals( 0, instance.getCampaignNumberLocalizedAreas( "123" ) );
    	
    	assertEquals( IIdeationCampaignService.WHOLE_AREA, instance.getCampaignWholeArea(       ) );
    	assertEquals( IIdeationCampaignService.WHOLE_AREA, instance.getCampaignWholeArea( "123" ) );

    	// Methods about phases
    	assertEquals( true, instance.isAfterBeginning(        Constants.IDEATION ) );
    	assertEquals( true, instance.isAfterBeginning( "123", Constants.IDEATION ) );

    	assertEquals( false, instance.isAfterEnd(        Constants.IDEATION ) );
    	assertEquals( false, instance.isAfterEnd( "123", Constants.IDEATION ) );

    	assertEquals( false, instance.isBeforeBeginning(        Constants.IDEATION ) );
    	assertEquals( false, instance.isBeforeBeginning( "123", Constants.IDEATION ) );

    	assertEquals( true, instance.isBeforeEnd(        Constants.IDEATION ) );
    	assertEquals( true, instance.isBeforeEnd( "123", Constants.IDEATION ) );

    	assertEquals( true, instance.isDuring(        Constants.IDEATION ) );
    	assertEquals( true, instance.isDuring( "123", Constants.IDEATION ) );

    	// Methods about themes
    	assertEquals( 3,  instance.getCampaignThemes(       ).size() );
    	assertEquals( 3,  instance.getCampaignThemes( "123" ).size() );
    }    
}
