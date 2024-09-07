package Panel.Test;

import org.testng.annotations.Test;

public class PanelStorePageTest {
    @SneakyThrows
    @Test(description = TEST_P_STORE_008, groups = {"panel"})
    public void checkingCityFilter() {
        PanelStorePage storePage = new PanelStorePage();
        String filterCityName = "İstanbul";
        wait(5);
        storePage.filterCity(filterCityName);
        wait(2);
        List<String> cityNameList = storePage.getCityNameList();

        boolean result = cityNameList.stream().allMatch(cityName -> cityName.equalsIgnoreCase(filterCityName));

        long istanbulCount = cityNameList.stream().filter(cityName -> cityName.equalsIgnoreCase(filterCityName)).count();
        System.out.println("Bulunan " + filterCityName + " sayısı: " + istanbulCount);

        assertTrue(result);
    }

    @SneakyThrows
    @Test(description = TEST_P_STORE_009, groups = {"panel"})
    public void checkingDistrictFilter(){
        PanelStorePage storePage = new PanelStorePage();
        String filterDistrictName = "Üsküdar";
        wait(5);
        storePage.filterDistrict(filterDistrictName);
        wait(2);

        List<String> districtNameList = storePage.getDistrictNameList();

        long matchingDistrictCount = districtNameList.stream()
                .filter(district -> district.equalsIgnoreCase(filterDistrictName))
                .count();

        System.out.println("Bulunan " + filterDistrictName + " sayısı: " + matchingDistrictCount);
        assertTrue(matchingDistrictCount > 0);
}
