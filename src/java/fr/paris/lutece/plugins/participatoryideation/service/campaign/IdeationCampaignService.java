/*
 * Copyright (c) 2002-2020, City of Paris
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
package fr.paris.lutece.plugins.participatoryideation.service.campaign;

import java.util.List;

import fr.paris.lutece.portal.service.spring.SpringContextService;
import fr.paris.lutece.util.ReferenceList;

/**
 * This class provides very simple ideation campaign services : - One 'whole city' area - No 'localized' area - Ideation is always open
 */
public class IdeationCampaignService implements IIdeationCampaignService
{

    private static final String CAMPAIGN_CODE = "A";
    private static final String CAMPAIGN_TITLE = "Ideation";

    // *********************************************************************************************
    // * SINGLETON SINGLETON SINGLETON SINGLETON SINGLETON SINGLETON SINGLETON SINGLETON SINGLETON *
    // * SINGLETON SINGLETON SINGLETON SINGLETON SINGLETON SINGLETON SINGLETON SINGLETON SINGLETON *
    // *********************************************************************************************

    private static final String BEAN_IDEATIONCAMPAIGN_SERVICE = "participatoryideation.ideationCampaignService";

    private static IIdeationCampaignService _singleton;

    public static IIdeationCampaignService getInstance( )
    {
        if ( _singleton == null )
        {
            _singleton = SpringContextService.getBean( BEAN_IDEATIONCAMPAIGN_SERVICE );
        }
        return _singleton;
    }

    // *********************************************************************************************
    // * CAMPAIGN CAMPAIGN CAMPAIGN CAMPAIGN CAMPAIGN CAMPAIGN CAMPAIGN CAMPAIGN CAMPAIGN CAMPAIGN *
    // * CAMPAIGN CAMPAIGN CAMPAIGN CAMPAIGN CAMPAIGN CAMPAIGN CAMPAIGN CAMPAIGN CAMPAIGN CAMPAIGN *
    // *********************************************************************************************

    // Provides list of campaigns
    public ReferenceList getCampaigns( )
    {
        ReferenceList allAreas = new ReferenceList( );
        allAreas.addItem( CAMPAIGN_CODE, CAMPAIGN_TITLE );
        return allAreas;
    }

    // *********************************************************************************************
    // * PHASES PHASES PHASES PHASES PHASES PHASES PHASES PHASES PHASES PHASES PHASES PHASES PHASE *
    // * PHASES PHASES PHASES PHASES PHASES PHASES PHASES PHASES PHASES PHASES PHASES PHASES PHASE *
    // *********************************************************************************************

    @Override
    public boolean isBeforeBeginning( String codeCampaign, String phase )
    {
        return false;
    }

    @Override
    public boolean isAfterBeginning( String codeCampaign, String phase )
    {
        return true;
    }

    @Override
    public boolean isDuring( String codeCampaign, String phase )
    {
        return true;
    }

    @Override
    public boolean isBeforeEnd( String codeCampaign, String phase )
    {
        return true;
    }

    @Override
    public boolean isAfterEnd( String codeCampaign, String phase )
    {
        return false;
    }

    @Override
    public boolean isBeforeBeginning( String phase )
    {
        return false;
    }

    @Override
    public boolean isAfterBeginning( String phase )
    {
        return true;
    }

    @Override
    public boolean isDuring( String phase )
    {
        return true;
    }

    @Override
    public boolean isBeforeEnd( String phase )
    {
        return true;
    }

    @Override
    public boolean isAfterEnd( String phase )
    {
        return false;
    }

    // *********************************************************************************************
    // * AREA AREA AREA AREA AREA AREA AREA AREA AREA AREA AREA AREA AREA AREA AREA AREA AREA AREA *
    // * AREA AREA AREA AREA AREA AREA AREA AREA AREA AREA AREA AREA AREA AREA AREA AREA AREA AREA *
    // *********************************************************************************************

    @Override
    public String getCampaignWholeArea( String codeCampaign )
    {
        return WHOLE_AREA;
    }

    @Override
    public ReferenceList getCampaignLocalizedAreas( String codeCampaign )
    {
        return new ReferenceList( );
    }

    @Override
    public int getCampaignNumberLocalizedAreas( String codeCampaign )
    {
        return 0;
    }

    @Override
    public String getCampaignWholeArea( )
    {
        return WHOLE_AREA;
    }

    @Override
    public ReferenceList getCampaignLocalizedAreas( )
    {
        return new ReferenceList( );
    }

    @Override
    public int getCampaignNumberLocalizedAreas( )
    {
        return 0;
    }

    @Override
    public ReferenceList getCampaignAllAreas( String codeCampaign )
    {
        ReferenceList allAreas = new ReferenceList( );
        allAreas.addItem( WHOLE_AREA, WHOLE_AREA );
        return allAreas;
    }

    @Override
    public ReferenceList getCampaignAllAreas( )
    {
        ReferenceList allAreas = new ReferenceList( );
        allAreas.addItem( WHOLE_AREA, WHOLE_AREA );
        return allAreas;
    }

    // *********************************************************************************************
    // * THEMES THEMES THEMES THEMES THEMES THEMES THEMES THEMES THEMES THEMES THEMES THEMES THEME *
    // * THEMES THEMES THEMES THEMES THEMES THEMES THEMES THEMES THEMES THEMES THEMES THEMES THEME *
    // *********************************************************************************************

    @Override
    public ReferenceList getCampaignThemes( String codeCampaign )
    {
        return getCampaignThemes( );
    }

    @Override
    public ReferenceList getCampaignThemes( )
    {
        ReferenceList items = new ReferenceList( );

        items.addItem( "GENERAL", "General" );
        items.addItem( "SOCIAL", "Social issues" );
        items.addItem( "SPORT", "Spooort !" );

        return items;
    }

    @Override
    public ReferenceList getCampaignThemesFrontRgb( String codeCampaign )
    {
        ReferenceList items = new ReferenceList( );

        items.addItem( "GENERAL", "#C00000" );
        items.addItem( "SOCIAL", "#00C000" );
        items.addItem( "SPORT", "#0000C0" );

        return items;
    }

}
