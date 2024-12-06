package cup.example;

import java.util.List;

class Driver {

	public static void main(String[] args) throws Exception {
		Parser parser = new Parser(); 
		parser.parse();
		
		var root = parser.getRootHtmlEl();
		
		output(root, 0);
	}
	
	public static void output(HtmlEl element, int depth) {
        if (element == null) {
            return;
        }

        if (element.getData() != null && !element.getData().equals("tel")) {
        	for (int i = 0; i < depth; i++) {
        		System.out.print("  ");
        	}
        	System.out.println(element.getData());
        }

        List<HtmlEl> children = element.getChildren();
        List<HtmlEl> brothers = element.getBrotherHtmlEls();
        if (element.getData() == null) {
        	children.forEach(child -> output(child, depth));
        } else {
        	children.forEach(child -> output(child, depth + 1));
        }
        brothers.forEach(brother -> output(brother, depth));
    }
	
}