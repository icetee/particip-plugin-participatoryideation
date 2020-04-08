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
package fr.paris.lutece.plugins.participatoryideation.business.notify;

import fr.paris.lutece.plugins.workflowcore.business.config.TaskConfig;

/**
 *
 * TaskNotifyDirectoryConfig
 *
 */
public class TaskNotifyIdeationConfig extends TaskConfig
{
    private String _strSubject;
    private String _strMessage;
    private String _strSenderName;
    private String _strSenderEmail;
    private String _strRecipientsCc;
    private String _strRecipientsBcc;
    private boolean _bFollowers;
    private boolean _bSubmitter;

    /**
     * Get the subject
     * 
     * @return the subject of the message
     */
    public String getSubject( )
    {
        return _strSubject;
    }

    /**
     * Set the subject of the message
     * 
     * @param subject
     *            the subject of the message
     */
    public void setSubject( String subject )
    {
        _strSubject = subject;
    }

    /**
     * Get the message
     * 
     * @return the message of the notification
     */
    public String getMessage( )
    {
        return _strMessage;
    }

    /**
     * Set the message of the notification
     * 
     * @param message
     *            the message of the notifictaion
     */
    public void setMessage( String message )
    {
        _strMessage = message;
    }

    /**
     * Get the sender name
     * 
     * @return the sender name
     */
    public String getSenderName( )
    {
        return _strSenderName;
    }

    /**
     * Set the sender name
     * 
     * @param senderName
     *            the sender name
     */
    public void setSenderName( String senderName )
    {
        _strSenderName = senderName;
    }

    /**
     * Get the sender email
     * 
     * @return the sender email
     */
    public String getSenderEmail( )
    {
        return _strSenderEmail;
    }

    /**
     * Set the sender email
     * 
     * @param senderEmail
     *            the sender email
     */
    public void setSenderEmail( String senderEmail )
    {
        _strSenderEmail = senderEmail;
    }

    /**
     * Returns the Recipient
     * 
     * @return The Recipient
     */
    public String getRecipientsCc( )
    {
        return _strRecipientsCc;
    }

    /**
     * Sets the Recipient
     * 
     * @param strRecipient
     *            The Recipient
     */
    public void setRecipientsCc( String strRecipient )
    {
        _strRecipientsCc = strRecipient;
    }

    /**
     * Returns the Recipient
     * 
     * @return The Recipient
     */
    public String getRecipientsBcc( )
    {
        return _strRecipientsBcc;
    }

    /**
     * Sets the Recipient
     * 
     * @param strRecipient
     *            The Recipient
     */
    public void setRecipientsBcc( String strRecipient )
    {
        _strRecipientsBcc = strRecipient;
    }

    /**
     * Returns if is Followers
     * 
     * @return If is Followers
     */
    public boolean isFollowers( )
    {
        return _bFollowers;
    }

    /**
     * Sets is Followers
     * 
     * @param bFollowers
     *            is Followers
     */
    public void setFollowers( boolean bFollowers )
    {
        this._bFollowers = bFollowers;
    }

    /**
     * Returns is Submitter
     * 
     * @return Is Submitter
     */
    public boolean isSubmitter( )
    {
        return _bSubmitter;
    }

    /**
     * Sets is Submitter
     * 
     * @param bSubmitter
     *            Is Submitter
     */
    public void setSubmitter( boolean bSubmitter )
    {
        this._bSubmitter = bSubmitter;
    }
}
