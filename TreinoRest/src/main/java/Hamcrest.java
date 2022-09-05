import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Hamcrest {

    @Test
    public void devoConhecerMatchersHamcrest(){

        Assert.assertThat("Maria", Matchers.is("Maria"));
        Assert.assertThat(128, Matchers.is(128));
        Assert.assertThat(120, Matchers.isA(Integer.class));
        Assert.assertThat(115.3, Matchers.isA(Double.class));
        Assert.assertThat(315, Matchers.greaterThan(310));
        Assert.assertThat(315, Matchers.lessThan(418));

        List<Integer> impares = Arrays.asList(1,3,5,7,9);
        Assert.assertThat(impares, Matchers.hasSize(5));
        Assert.assertThat(impares, Matchers.contains(1,3,5,7,9));
        Assert.assertThat(impares, Matchers.containsInAnyOrder(1,5,7,3,9));
        Assert.assertThat(impares, Matchers.hasItem(1));
        Assert.assertThat(impares, Matchers.hasItems(1,5));

        Assert.assertThat("Maria", Matchers.is(Matchers.not("João")));
        Assert.assertThat("Maria", Matchers.anyOf(Matchers.is("Maria"),Matchers.is("Joaquina")));
        Assert.assertThat("Joaquina", Matchers.allOf(Matchers.startsWith("Joa"), Matchers.endsWith("ina"),Matchers.containsString("qui")));

    }
}
