/* Hackerrank
 * Check if IP is ipv4 or ipv6
 */

public static String detectIP(String ip){
	Pattern ipv4 = Pattern.compile("\\A(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}\\z");
	Pattern ipv6 = Pattern.compile("[A-fa-f0-9]{1,4}:[A-Fa-f0-9]{1,4}:[A-fa-f0-9]{1,4}:[A-Fa-f0-9]{1,4}:[A-fa-f0-9]{1,4}:[A-Fa-f0-9]{1,4}:[A-fa-f0-9]{1,4}:[A-Fa-f0-9]{1,4}");
	if (ipv4.matcher(ip).matches()){
		return "IPv4";
	}else if(ipv6.matcher(ip).matches()){
		return "IPv6";
	}else{
		return "Neither";
	}
}