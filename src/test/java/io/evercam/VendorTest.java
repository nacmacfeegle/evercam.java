//package io.evercam;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import java.util.ArrayList;
//
//import static junit.framework.Assert.assertEquals;
//
//public class VendorTest
//{
//    private static final String TEST_VENDOR_ID = "testid";
//    private static final String TEST_VENDOR_MAC = "00:73:57";
//
//
//    @BeforeClass
//    public static void setUpClass()
//    {
//        API.URL = TestURL.URL;
//    }
//
//    @Test
//    public void testGetVendorInfo() throws EvercamException
//    {
//        API.setDeveloperKeyPair("apikey", "apiid");
//        Vendor axis = Vendor.getByMac(TEST_VENDOR_MAC).get(0);
//        assertEquals("Ubiquiti Networks", axis.getName());
//        assertEquals(TEST_VENDOR_ID, axis.getId());
//        assertEquals(true, axis.getKnownMacs().contains(TEST_VENDOR_MAC));
//        assertEquals(5, axis.getKnownMacs().size());
//        assertEquals(true, axis.isSupported());
//        API.setDeveloperKeyPair(null, null);
//    }
//
//    @Test
//    public void testGetAll() throws EvercamException
//    {
//        API.setDeveloperKeyPair("apikey", "apiid");
//        assertEquals(2, Vendor.getAll().size());
//        API.setDeveloperKeyPair(null, null);
//    }
//
//    @Test
//    public void testGetById() throws EvercamException
//    {
//        API.setDeveloperKeyPair("apikey", "apiid");
//        Vendor vendor = Vendor.getById("testid");
//        assertEquals("testid", vendor.getId());
//        API.setDeveloperKeyPair(null, null);
//    }
//
//    @Test
//    public void testGetByMac() throws EvercamException
//    {
//        API.setDeveloperKeyPair("apikey", "apiid");
//        assertEquals(1, Vendor.getByMac(TEST_VENDOR_MAC).size());
//        API.setDeveloperKeyPair(null, null);
//    }
//
//    @Test
//    public void testGetModel() throws EvercamException
//    {
//        API.setDeveloperKeyPair("apikey", "apiid");
//        Model model = Vendor.getById("testid").getModel("YCW005");
//        ArrayList<String> models = model.getKnownModels();
//        assertEquals(1, models.size());
//        assertEquals("testid", model.getVendor());
//        assertEquals("YCW005", model.getName());
//        assertEquals(1, model.getKnownModels().size());
//        assertEquals("admin", model.getDefaults().getAuth(Auth.TYPE_BASIC).getUsername());
//        assertEquals("12345", model.getDefaults().getAuth(Auth.TYPE_BASIC).getPassword());
//        assertEquals("/Streaming/channels/1/picture", model.getDefaults().getJpgURL());
//        assertEquals("snapshot/h264", model.getDefaults().getH264URL());
//        assertEquals("snapshot/lowres", model.getDefaults().getLowresURL());
//        assertEquals("", model.getDefaults().getMpeg4URL());
//        assertEquals("snapshot/mobile", model.getDefaults().getMobileURL());
//        assertEquals("snapshot/mjpg", model.getDefaults().getMjpgURL());
//        API.setDeveloperKeyPair(null, null);
//    }
//
//    @Test
//    public void testGetSupportedVendors() throws EvercamException
//    {
//        API.setDeveloperKeyPair("apikey", "apiid");
//        ArrayList<Vendor> vendors = Vendor.getSupportedVendors();
//        assertEquals(2, vendors.size());
//        ArrayList<String> models = vendors.get(1).getModels();
//        assertEquals(4, models.size());
//        API.setDeveloperKeyPair(null, null);
//    }
//}