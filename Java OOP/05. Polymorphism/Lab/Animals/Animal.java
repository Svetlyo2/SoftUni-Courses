package Animals;

public abstract class Animal {
    private String name;
    private String favoriteFood;

    public Animal(String name, String favoriteFood) {
        this.name = name;
        this.favoriteFood = favoriteFood;
    }

    public String getName() {
        return name;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public abstract String explainSelf();
//    {
//        return String .format("I am %s and my favorite food is %s",
//                this.name,this.favoriteFood);
//    };

}
