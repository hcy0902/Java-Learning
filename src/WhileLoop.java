public class WhileLoop {

    public static void main(String args[]){

        String str = "We have a large inventory of things in our warehouse falling in "
                + "the category:apparel and the slightly "
                + "more in demand category:makeup along with the category:furniture and...";

        printCategories(str);

    }

    public static void printCategories(String string){
        int i = 0;
        while(true){
            int found = string.indexOf("category:", i);
            if(found == -1) break;
            int start = found +9;
            int end = string.indexOf(" ", start);
            System.out.println(string.substring(start, end));
            i = end+1;

        }
        /*{
            String name = "sfdfewencsoidfhsjdf";

            for (int b = 0; b <= name.length() -1; b++){

                System.out.println("char: "+ name.charAt(b));
            }

            {String name1 = "sfdfewencsoidfhsjdf";

                for (int c = name1.length()-1; c >= 0 -1; c--){

                    System.out.println("char: "+ name1.charAt(c));
                }

            }


            {
                for(int d = 0; d <=100; d += 2){
                    System.out.println(d);

                }
            }

        }*/
    }
}
