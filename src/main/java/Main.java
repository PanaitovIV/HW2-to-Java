import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String strFilter = "\"name:Ivanov\" \"country:Russia\" \"city:Moscow\" \"age:null\"";
        String[] strFilterArrNew = strFilter.split("\"?\\s+\"?|:\"?");
        System.out.println(Arrays.toString(strFilterArrNew));
        if (strFilterArrNew.length > 0) {
            String[] keyValuePairs = strFilterArrNew[0].split(",");
        }
        StringBuilder filterBuilder = new StringBuilder();

        for (int i = 0; i < strFilterArrNew.length + 1; i += 2) {
            if (i + 1 < strFilterArrNew.length) {
                String key = strFilterArrNew[i];
                String value = strFilterArrNew[i + 1];
                if (!value.equals("null\"") && !value.equals("null")) {
                    if (filterBuilder.length() > 0) {
                        filterBuilder.append(" and ");
                    }
                    filterBuilder.append(key).append(" = '").append(value).append("'\"");
                }
            }
        }
        String filter = filterBuilder.toString();
        System.out.println(filter);
    }
}