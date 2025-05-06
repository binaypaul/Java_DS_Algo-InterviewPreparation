public class Base62EncoderForUrlShortening {
    public static void main(String[] args) {
        System.out.println(new Base62EncoderForUrlShortening().encodeBase62(1000L));
    }

    private String encodeBase62(long id) {
        char[] charArr = new char[] {
                '0','1','2','3','4','5','6','7','8','9',
                'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
        };
        StringBuilder encoded = new StringBuilder();
        while (id > 0) {
            int rem = Math.toIntExact(id % 62);
            id = id/62;
            encoded.insert(0, charArr[rem]);
        }
        while (encoded.length() < 7) {
            encoded.insert(0, '_');
        }
        return encoded.toString();
    }
}

