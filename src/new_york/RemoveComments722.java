package new_york;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments722 {
    public List<String> removeComments(String[] source) {
        int indexSingle = 0;
        int indexMulti = 0;
        List<String> code = new ArrayList<>();
        for(int i=0; i<source.length; i++) {
            String str = source[i];
            indexSingle = str.indexOf("//");
            indexMulti = str.indexOf("/*");

            if(indexSingle != -1) {
                if(indexMulti != -1) {
                    if(indexMulti < indexSingle) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str.substring(0, indexMulti));
                        i = findMultiEnd(i, source);
                        sb.append(source[i].substring(source[i].lastIndexOf("*/")+2, source[i].length()));
                        if(sb.length() != 0) {
                            code.add(sb.toString());
                        }
                    } else {
                        code.add(str.substring(0,indexSingle));
                    }
                }
                else {
                    code.add(str.substring(0,indexSingle));
                }
            } else if(indexMulti != -1) {
                StringBuilder sb = new StringBuilder();
                sb.append(str.substring(0,indexMulti));
                i = findMultiEnd(i, source);
                sb.append(source[i].substring(source[i].indexOf("*/")+2, source[i].length()));
                if(sb.length() != 0) {
                    code.add(sb.toString());
                }
            } else {
                code.add(str);
            }

        }
        return code;
    }

    private static int findMultiEnd(int index, String[] source) {
        for(int i= index; i<source.length; i++) {
            int start = source[i].indexOf("/*");
            if(start == -1 && source[i].indexOf("*/") != -1) {
                return i;
            }
            if(start != -1 && source[i].lastIndexOf("*/") >= start + 2) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new RemoveComments722().removeComments(new String[]{"a//*b//*c","blank","d/*/e*//f"});
    }
}
