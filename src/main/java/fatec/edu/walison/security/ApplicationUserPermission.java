package fatec.edu.walison.security;

public enum ApplicationUserPermission {
	
	CLIENT_READ("client:read"),
	ADMIN_WRITE("admin:write");
	
	private final String permissions;
	
	private ApplicationUserPermission(String permissions) {
		this.permissions = permissions;
	} 
	
	public String getPermission() {
		return this.permissions;
	}
}
