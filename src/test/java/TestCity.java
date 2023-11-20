import com.city.controller.CityController;
import com.tools.AwsUtilsConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestCity.class)
@ComponentScan(basePackages = "com")
@TestPropertySource(locations = "classpath:application.properties")
public class TestCity {

    @Autowired
    private CityController cityController;

    private MockMvc mockMvc;

    //test city1
    @Test
    public void test01() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(cityController).build();

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/city/getCityById")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .param("cityId", "1")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("200"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("success"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.city").value("Auckland"));;
    }
    //test city2
    @Test
    public void test02() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(cityController).build();

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/city/getCityById")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .param("cityId", "2")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("200"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("success"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.city").value("Wellington"));;
    }
    //test city3
    @Test
    public void test03() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(cityController).build();

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/city/getCityById")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .param("cityId", "3")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("200"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("success"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.city").value("Bay of Plenty"));;

    }
    //can't find city
    @Test
    public void test04() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(cityController).build();

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/city/getCityById")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .param("cityId", "4")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("CITY10000"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("not found city"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").isEmpty());
    }
}