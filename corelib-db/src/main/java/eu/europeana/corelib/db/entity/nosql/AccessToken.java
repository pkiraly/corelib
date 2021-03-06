/**
	 * Only for internal (test) usage, clears a table...
	 */
package eu.europeana.corelib.db.entity.nosql;

import java.util.Date;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Indexed;

/**
 * Class representing an OAuth2AccessToken
 */
@Entity("OAuth2AccesssToken")
public class AccessToken extends RefreshToken {

	@Indexed(unique = true)
	private String authenticationId;

	@Indexed(unique = false)
	private String userName;

	@Indexed(unique = false)
	private String clientId;

	private String refreshToken;

	private Date expires;

	/**
	 * Empty constructor
	 */
	public AccessToken() {
	}

	/**
	 * Default constructor
	 * @param id The id of the token
	 * @param expires The expiration date of the token
	 */
	public AccessToken(String id, Date expires) {
		super(id);
		this.expires = new Date(expires.getTime());
	}

	/**
	 * GETTERS & SETTTERS
	 */

	public void setAuthenticationId(String authenticationId) {
		this.authenticationId = authenticationId;
	}

	public String getAuthenticationId() {
		return authenticationId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public Date getExpires() {
		return new Date(expires.getTime());
	}

	public void setExpires(Date expires) {
		this.expires = new Date(expires.getTime());
	}
}
