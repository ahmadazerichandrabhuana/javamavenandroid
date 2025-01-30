import org.testng.annotations.Test;

public class Test002 extends TestParent{

    @Test(description = "As an Android user, I should be able to see page \"Productssss\" when first Open the Apps... but Failed")
    public void test() {
        productsPage.swipeUp();
        productsPage.swipeDown();
        productsPage.swipeUp();
        productsPage.swipeDown();
        productsPage.verifyHeaderProductsAppearFailed();
    }
}
