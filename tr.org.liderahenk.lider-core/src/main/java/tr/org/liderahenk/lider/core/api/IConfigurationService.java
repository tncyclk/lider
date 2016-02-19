package tr.org.liderahenk.lider.core.api;

/**
 * 
 * Provides configuration service for all Lider server components
 *
 * @author <a href="mailto:birkan.duman@gmail.com">Birkan Duman</a>
 * @author <a href="mailto:emre.akkaya@agem.com.tr">Emre Akkaya</a>
 * 
 */
public interface IConfigurationService {
	/**
	 * 
	 * @return ldap server host
	 */
	String getLdapServer();

	/**
	 * 
	 * @return ldap server port
	 */
	String getLdapPort();

	/**
	 * 
	 * @return ldap bind user
	 */
	String getLdapUser();

	/**
	 * 
	 * @return ldap bind password
	 */
	String getLdapPassword();

	/**
	 * 
	 * @return ldap root DN
	 */
	String getLdapRootDn();

	/**
	 * 
	 * @return true if using LDAPS, false otherwise
	 */
	Boolean getLdapUseSsl();

	/**
	 * 
	 * @return xmpp bind password
	 */
	String getXmppPassword();

	/**
	 * 
	 * @return xmpp server port
	 */
	Integer getXmppPort();

	/**
	 * 
	 * @return ldap base DN for agent entries
	 */
	String getAgentLdapBaseDn();

	/**
	 * 
	 * @return ldap agent id attribute for agent entries
	 */
	String getAgentLdapIdAttribute();

	/**
	 * 
	 * @return ldap agent jid attribute for agent entries
	 */
	String getAgentLdapJidAttribute();

	/**
	 * 
	 * @return ldap user search base dn for authentication
	 */
	String getAuthLdapUserSearchBase();

	/**
	 * 
	 * @return ldap user search filter for authentication
	 * @deprecated use
	 *             {@link IConfigurationService#getAuthLdapUserObjectClasses()}
	 *             and {@link IConfigurationService#getAuthLdapUserAttribute()}
	 */
	String getAuthLdapUserFilter();

	/**
	 * 
	 * @return comma separated ldap user object classes to be used in search
	 *         filter for authentication
	 * 
	 */
	String getAuthLdapUserObjectClasses();

	/**
	 * 
	 * @return ldap user attribute for authentication
	 */
	String getAuthLdapUserAttribute();

	/**
	 * 
	 * @return true if ldap authorization enabled, false otherwise
	 */
	Boolean getAuthorizationEnabled();

	/**
	 * 
	 * @return default task timeout (in milliseconds) for task manager
	 */
	Long getTaskManagerTaskTimeout();

	/**
	 * 
	 * @return true if clustering enabled in task manager store
	 */
	Boolean getTaskManagerMulticastEnabled();

	/**
	 * 
	 * @return true if xmpp message logs enabled
	 */
	Boolean getTaskManagerLogXmppMessagesEnabled();

	/**
	 * @return XMPP host IP
	 */
	String getXmppHost();

	/**
	 * @return XMPP service name / domain
	 */
	String getXmppServiceName();

	/**
	 * @return XMPP username
	 */
	String getXmppUserName();

	/**
	 * @return packet replay timeout in ms
	 */
	int getXmppPacketReplayTimeout();

	/**
	 * @return max retry connection count
	 */
	int getXmppMaxRetryConnectionCount();

	/**
	 * 
	 * @return default timeout (in milliseconds) for xmpp ping requests
	 */
	Integer getXmppPingTimeout();

	/**
	 * 
	 * @return all server public IP for use in remote connections
	 */
	String getServers();

	String getPrivateKey();

	/***
	 * 
	 * @return Maximum length of querying log by day
	 */
	Integer getSyslogRecordMaxQueryDay();

	String getMailAddress();

	String getMailPassword();

	String getMailHost();

	Integer getMailSmtpPort();

	Boolean getMailSmtpAuth();

	String getUserMailAttribute();

	/**
	 * @return
	 */
	Integer getMailSmtpWriteTimeout();

	/**
	 * @return
	 */
	Integer getMailSmtpTimeout();

	/**
	 * @return
	 */
	Integer getMailSmtpConnTimeout();

	/**
	 * @return
	 */
	Boolean getMailSmtpSslEnable();

	/**
	 * @return
	 */
	Boolean getMailSmtpStartTlsEnable();

}
