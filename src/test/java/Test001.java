import org.testng.annotations.Test;

public class Test001 extends TestParent{

    @Test(description = "As an Android user, I should be able to see page \"Products\" when first Open the Apps")
    public void test() {
        productsPage.swipeUp();
        productsPage.swipeDown();
        productsPage.swipeUp();
        productsPage.swipeDown();
        productsPage.verifyHeaderProductsAppear();
    }
}
