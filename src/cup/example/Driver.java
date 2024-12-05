package cup.example;

import java.util.List;

class Driver {

    public static void main(String[] args) throws Exception {
        Parser parser = new Parser(); 
        parser.parse();

        HtmlEl root = parser.getRootHtmlEl();

        printHtmlElementTree(root, 0);
    }

    private static void printHtmlElementTree(HtmlEl element, int depth) {
        if (element == null) {
            return;
        }

        printElementData(element, depth);

        List<HtmlEl> children = element.getChildren();
        List<HtmlEl> brothers = element.getBrotherHtmlEls();

        int nextDepth = element.getData() == null ? depth : depth + 1;

        children.forEach(child -> printHtmlElementTree(child, nextDepth));
        brothers.forEach(brother -> printHtmlElementTree(brother, depth));
    }

    private static void printElementData(HtmlEl element, int depth) {
        String data = element.getData();
        if (data != null && !data.equals("tel")) {
            printIndented(data, depth);
        }
    }

    private static void printIndented(String data, int depth) {
        System.out.println("  ".repeat(depth) + data);
    }
}
