package resources;

public class ResourceServerController implements ResourceServerMBean {
    private final TestResource testResource;

    public ResourceServerController(TestResource testResource) {
        this.testResource = testResource;
    }
    @Override
    public String gettName() {
        return testResource.getName();
    }

    @Override
    public int gettAge() {
        return testResource.getAge();
    }
}
