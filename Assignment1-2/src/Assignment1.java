
public class Assignment1 {
	
	public static void printPattern() {
		StringBuilder output = new StringBuilder("");
		for (int i = 0; i < 4; i++) {
			StringBuilder patterns = new StringBuilder();
//			output.append("\n");
			output.append("\n" + (i + 1) + ")\n");
			for (int j = 0; j < 5; j++) {
				if (i < 2) {
                    StringBuilder pattern = new StringBuilder(j < 4 ? "*".repeat(j+1) + "\n" : ".".repeat(9 + i));
					patterns.append(pattern);
				} else {
                    if (j < 4) {
                        String spaces = " ".repeat(5-j);
                        StringBuilder pattern = new StringBuilder("*".repeat(j+1 + j) + "\n");
                        int spaceIndex = (i + 1) % 2 == 0 ? pattern.length() - 1 : 0; // if number is even insert spaces at the end of pattern
                        patterns.append(pattern.insert(spaceIndex, spaces));
                    } else {
                        patterns.append(".".repeat(9 + i));
                    }
				}
			}
			output.append((i + 1) % 2 == 0 ? patterns.reverse() : patterns); // if i is even invert the pattern
		}
		System.out.println(output.toString());
	}
	
	public static void main(String[] args) {
		printPattern();
	}

}
