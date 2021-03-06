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
package fr.paris.lutece.plugins.participatoryideation.business.link;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.util.sql.DAOUtil;

/**
 * This class provides Data Access methods for link objects
 */

public final class LinkDAO implements ILinkDAO
{
    // Constants
    private static final String SQL_QUERY_NEW_PK = "SELECT max( id_proposal_link ) FROM participatoryideation_proposals_links";

    private static final String SQL_QUERY_SELECTALL = "SELECT  l.id_proposal_link, l.id_proposal_parent, l.id_proposal_child, ip.code_campaign, ic.code_campaign, ip.code_proposal, ic.code_proposal, ip.titre, ic.titre FROM participatoryideation_proposals_links AS l INNER JOIN participatoryideation_proposals AS ip ON ip.id_proposal = l.id_proposal_parent INNER JOIN participatoryideation_proposals AS ic ON ic.id_proposal = l.id_proposal_child";
    private static final String SQL_QUERY_SELECT = SQL_QUERY_SELECTALL + " WHERE id_proposal_link = ?";
    private static final String SQL_QUERY_SELECTALL_ID = "SELECT id_proposal_link FROM participatoryideation_proposals_links";

    private static final String SQL_QUERY_INSERT = "INSERT INTO participatoryideation_proposals_links ( id_proposal_link, id_proposal_parent, id_proposal_child ) VALUES ( ?, ?, ? ) ";
    private static final String SQL_QUERY_DELETE = "DELETE FROM participatoryideation_proposals_links WHERE id_proposal_link = ? ";
    private static final String SQL_QUERY_UPDATE = "UPDATE participatoryideation_proposals_links SET id_proposal_link = ?, id_proposal_parent = ?, id_proposal_child = ? WHERE id_proposal_link = ?";

    /**
     * Generates a new primary key
     * 
     * @param plugin
     *            The Plugin
     * @return The new primary key
     */
    public int newPrimaryKey( Plugin plugin )
    {
        int nKey = 1;

        try ( DAOUtil daoUtil = new DAOUtil( SQL_QUERY_NEW_PK, plugin ) )
        {
            daoUtil.executeQuery( );

            if ( daoUtil.next( ) )
            {
                nKey = daoUtil.getInt( 1 ) + 1;
            }
        }

        return nKey;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void insert( Link link, Plugin plugin )
    {
        try ( DAOUtil daoUtil = new DAOUtil( SQL_QUERY_INSERT, plugin ) )
        {
            link.setId( newPrimaryKey( plugin ) );

            daoUtil.setInt( 1, link.getId( ) );
            daoUtil.setInt( 2, link.getParentId( ) );
            daoUtil.setInt( 3, link.getChildId( ) );

            daoUtil.executeUpdate( );
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public Link load( int nKey, Plugin plugin )
    {
        Link link = null;

        try ( DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECT, plugin ) )
        {
            daoUtil.setInt( 1, nKey );
            daoUtil.executeQuery( );

            if ( daoUtil.next( ) )
            {
                link = getRow( daoUtil );
            }
        }

        return link;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void delete( int nKey, Plugin plugin )
    {
        try ( DAOUtil daoUtil = new DAOUtil( SQL_QUERY_DELETE, plugin ) )
        {
            daoUtil.setInt( 1, nKey );
            daoUtil.executeUpdate( );
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void store( Link link, Plugin plugin )
    {
        try ( DAOUtil daoUtil = new DAOUtil( SQL_QUERY_UPDATE, plugin ) )
        {
            daoUtil.setInt( 1, link.getId( ) );
            daoUtil.setInt( 2, link.getParentId( ) );
            daoUtil.setInt( 3, link.getChildId( ) );
            daoUtil.setInt( 4, link.getId( ) );

            daoUtil.executeUpdate( );
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public Collection<Link> selectLinksList( Plugin plugin )
    {
        Collection<Link> linkList = new ArrayList<>( );

        try ( DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECTALL, plugin ) )
        {
            daoUtil.executeQuery( );

            while ( daoUtil.next( ) )
            {
                Link link = getRow( daoUtil );
                linkList.add( link );
            }
        }

        return linkList;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public Collection<Integer> selectIdLinksList( Plugin plugin )
    {
        Collection<Integer> linkList = new ArrayList<>( );

        try ( DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECTALL_ID, plugin ) )
        {
            daoUtil.executeQuery( );

            while ( daoUtil.next( ) )
            {
                linkList.add( daoUtil.getInt( 1 ) );
            }
        }

        return linkList;
    }

    private Link getRow( DAOUtil daoUtil )
    {
        int nCpt = 1;

        Link link = new Link( );

        link.setId( daoUtil.getInt( nCpt++ ) );
        link.setParentId( daoUtil.getInt( nCpt++ ) );
        link.setChildId( daoUtil.getInt( nCpt++ ) );
        link.setParentCodeCampaign( daoUtil.getString( nCpt++ ) );
        link.setChildCodeCampaign( daoUtil.getString( nCpt++ ) );
        link.setParentCodeProposal( daoUtil.getInt( nCpt++ ) );
        link.setChildCodeProposal( daoUtil.getInt( nCpt++ ) );
        link.setParentTitle( daoUtil.getString( nCpt++ ) );
        link.setChildTitle( daoUtil.getString( nCpt++ ) );

        return link;
    }

    /*
     * *********************************************************************************** SEARCH SEARCH SEARCH SEARCH SEARCH SEARCH SEARCH SEARCH SEARCH SEARCH
     * SEARCH SE * SEARCH SEARCH SEARCH SEARCH SEARCH SEARCH SEARCH SEARCH SEARCH SEARCH SEARCH SE
     * ***********************************************************************************
     */

    @Override
    public Collection<Link> selectLinksListSearch( LinkSearcher linkSearcher, Plugin plugin )
    {
        Map<Integer, Link> linkMap = new LinkedHashMap<>( );

        String queryStr = ( linkSearcher != null ) ? appendFilters( SQL_QUERY_SELECTALL, linkSearcher ) : SQL_QUERY_SELECTALL;
        try ( DAOUtil daoUtil = new DAOUtil( queryStr, plugin ) )
        {
            if ( linkSearcher != null )
            {
                setFilterValues( daoUtil, linkSearcher );
            }
            daoUtil.executeQuery( );

            while ( daoUtil.next( ) )
            {
                Link link = getRow( daoUtil );
                linkMap.put( link.getId( ), link );
            }
        }

        ArrayList<Link> result = new ArrayList<>( linkMap.values( ) );
        return result;
    }

    /**
     * Creates the preparedStatement for apply filters
     * 
     * @param query
     *            The begining of the query
     * @param linkSearcher
     *            The linkSearcher
     * @return The sql statement
     */
    private String appendFilters( String query, LinkSearcher linkSearcher )
    {
        // Create the where clause
        StringBuilder stringBuilder = new StringBuilder( );

        if ( linkSearcher.getCodeCampaign( ) != null )
        {
            stringBuilder.append( " ( ip.code_campaign = ? OR ic.code_campaign = ? ) AND" );
        }

        if ( linkSearcher.getCodeProposal( ) != null )
        {
            stringBuilder.append( " ( ip.code_proposal = ? OR ic.code_proposal = ? ) AND" );
        }

        if ( linkSearcher.getTitle( ) != null )
        {
            stringBuilder.append( " ( ip.titre LIKE ? OR ic.titre LIKE ? ) AND" );
        }

        if ( stringBuilder.length( ) > 0 )
        {
            // Remove the final " AND"
            stringBuilder.setLength( stringBuilder.length( ) - 4 );
        }

        // Assemble all clauses
        StringBuilder finalQuery = new StringBuilder( );
        finalQuery.append( query );

        if ( stringBuilder.length( ) > 0 )
        {
            finalQuery.append( " WHERE " );
            finalQuery.append( stringBuilder.toString( ) );
        }

        finalQuery.append( " ORDER BY l.id_proposal_parent DESC, l.id_proposal_child ASC" );

        return finalQuery.toString( );
    }

    private void setFilterValues( DAOUtil daoUtil, LinkSearcher linkSearcher )
    {
        int nCpt = 1;

        if ( linkSearcher.getCodeCampaign( ) != null )
        {
            daoUtil.setString( nCpt++, linkSearcher.getCodeCampaign( ) );
            daoUtil.setString( nCpt++, linkSearcher.getCodeCampaign( ) );
        }
        if ( linkSearcher.getCodeProposal( ) != null )
        {
            daoUtil.setInt( nCpt++, linkSearcher.getCodeProposal( ) );
            daoUtil.setInt( nCpt++, linkSearcher.getCodeProposal( ) );
        }
        if ( linkSearcher.getTitle( ) != null )
        {
            daoUtil.setString( nCpt++, "%" + linkSearcher.getTitle( ) + "%" );
            daoUtil.setString( nCpt++, "%" + linkSearcher.getTitle( ) + "%" );
        }
    }

}
