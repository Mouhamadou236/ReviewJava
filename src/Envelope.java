import java.util.ArrayList;
import java.util.List;

public class Envelope implements Component{
    private final int MAX_CONTAIN = 10;
    private final List<Component> components;
    private boolean EnvelopeIsOpen;

    public Envelope() {
        this.components = new ArrayList<>();
    }

    public void close() {
        this.EnvelopeIsOpen = false;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void open() {
        this.EnvelopeIsOpen = true;
    }

    /**
     *
     * @param component
     */
    public void addComponent(Component component) {
        if (component instanceof File){
            ((File) component).disableAccess();
        }
        if (this.nbFiles() < this.MAX_CONTAIN && EnvelopeIsOpen) {
            this.components.add(component);
        } else {
            System.out.println("L'enveloppe est fermée.");
        }
    }

    /**
     * Read all the component in the current envelope
     */
    public void read() {
        if (EnvelopeIsOpen) {
            components.forEach(component -> {
                if (component instanceof File){
                    System.out.println(((File) component).getFont());
                    System.out.println(((File) component).getBack());
                }if (component  instanceof Envelope){
                    ((Envelope) component).open();
                    component.read();
                }
            });
        } else {
            System.out.println("Enveloppe fermée");
        }
    }

    public int nbFiles() {
        return this.components.size();
    }

    public void removeComponent(Component component){
        this.components.remove(component);
    }
}
