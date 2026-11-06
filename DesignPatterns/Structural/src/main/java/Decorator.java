interface PizzaMaking {
    String getDescription();
    double getPrice();
}

// Base pizza
class ValconaPizza implements PizzaMaking {

    @Override
    public String getDescription() {
        return "Valcona Pizza";
    }

    @Override
    public double getPrice() {
        return 200;
    }
}

// Abstract decorator
abstract class PizzaDecorator implements PizzaMaking {

    protected PizzaMaking pizzaMaking;

    public PizzaDecorator(PizzaMaking pizzaMaking) {
        this.pizzaMaking = pizzaMaking;
    }
}

// Extra cheese decorator
class ExtraPizza extends PizzaDecorator {

    public ExtraPizza(PizzaMaking pizzaMaking) {
        super(pizzaMaking);
    }

    @Override
    public String getDescription() {
        return pizzaMaking.getDescription() + ", Extra Cheese";
    }

    @Override
    public double getPrice() {
        return pizzaMaking.getPrice() + 40;
    }
}

// Olives decorator
class Olives extends PizzaDecorator {

    public Olives(PizzaMaking pizzaMaking) {
        super(pizzaMaking);
    }

    @Override
    public String getDescription() {
        return pizzaMaking.getDescription() + ", Olives";
    }

    @Override
    public double getPrice() {
        return pizzaMaking.getPrice() + 30;
    }
}

public class Decorator {

    public static void main(String[] args) {

        PizzaMaking pizza = new ValconaPizza();

        pizza = new ExtraPizza(pizza);

        pizza = new Olives(pizza);

        System.out.println(pizza.getDescription());
        System.out.println("Total Price: " + pizza.getPrice());
    }
}