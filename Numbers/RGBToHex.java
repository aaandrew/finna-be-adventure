/*
 * Convert RGB value (three 1-byte numbers) to a 6-digit hexadecimal string
 */
public static String RGBToHex(int r, int g, int b){
	return (toHex(r) + toHex(g) + toHex(b)).toUpperCase();
}

public String toHex(int value){
	StringBuilder sb = new StringBuilder(Integer.toHexString(value & 0xff));
	while(sb.length() < 2){
		sb.append("0");
	}
	return sb.toString().toUpperCase();
}

// O2X - 0 zero padded, width 2, X hex uppercase
public static String RGBToHex(int r, int g, int b){
	return String.format("%02X%02X%02X", r, g, b);
}