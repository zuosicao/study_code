package cong.ruan.common.pojos;

/**
 * 
 * @author RuanCong
 * @time 2014-4-28 下午1:30:03
 */
public class AccessToken
{
	private String accessToken;
	private int expiresIn;
	
	public String getAccessToken()
	{
		return accessToken;
	}
	public void setAccessToken(String accessToken)
	{
		this.accessToken = accessToken;
	}
	public int getExpiresIn()
	{
		return expiresIn;
	}
	public void setExpiresIn(int expiresIn)
	{
		this.expiresIn = expiresIn;
	}
	public AccessToken(String accessToken, int expiresIn)
	{
		this.accessToken = accessToken;
		this.expiresIn = expiresIn;
	}
	
	
}
