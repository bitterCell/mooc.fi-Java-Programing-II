
import java.util.ArrayList;

public class Suitcase {

    private int maximumWeight;
    private ArrayList<Item> Items;

    public Suitcase(int maximumWeight) {
        this.Items = new ArrayList<>();
        this.maximumWeight = maximumWeight;
    }

    public void addItem(Item Item) {
        if (this.totalWeight() + Item.getWeight() > this.maximumWeight) {
            return;
        }

        this.Items.add(Item);
    }

    public int totalWeight() {
        int sum = this.Items.stream()
                         .map(s -> s.getWeight())
                         .reduce(0, (previous, current) -> previous + current);
        return sum;
    }

    public void printItems() {
        this.Items.stream()
                  .forEach(s -> System.out.println(s));
    }

    public Item heaviestItem() {
        if (this.Items.isEmpty()) {
            return null;
        }

        // We will get to know the organization a little later in the course
        return this.Items.stream().max((t1, t2) -> t1.getWeight() - t2.getWeight()).get();
    }

    @Override
    public String toString() {
        if (this.Items.isEmpty()) {
            return "no items (0 kg)";
        }

        if (this.Items.size() == 1) {
            return "1 item (" + this.totalWeight() + " kg)";
        }

        return this.Items.size() + " items (" + this.totalWeight() + " kg)";
    }
}