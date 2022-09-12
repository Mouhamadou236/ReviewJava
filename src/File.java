public class File implements Component {
    private final String font;
    private final String back;
    private boolean fontIsVisible;
    private boolean accessAuthorized;
    private static int MAX_INSTANCE;
    private static int CURRENT_INSTANCE = 0;
    public File(String font, String back){
        this.font = font;
        this.back = back;
        this.fontIsVisible = true;
        this.accessAuthorized = true;
        CURRENT_INSTANCE++;
        if (CURRENT_INSTANCE >= MAX_INSTANCE){
            System.out.println("Halte au gaspillage !");
        }
    }

    /**
     * Verify if accessAuthorized
     * And read recto and verso to the current file
     */
    public void read() {
        if (!this.accessAuthorized){
            System.out.println("Accès refusé");
            return;
        }
        if (this.fontIsVisible){
            System.out.println(this.font);
        }else {
            System.out.println(this.back);
        }
    }
    public void ToReturn(){
        this.fontIsVisible = !this.fontIsVisible;
    }

    public String getFont() {
        return this.font;
    }

    public String getBack() {
        return back;
    }

    public void disableAccess() {
        this.accessAuthorized = false;
    }
    public static void maxInstanceOfFile(int max){
        MAX_INSTANCE = max;
    }

}
