package net.config

/**
 * @author dmillett
 */
class ConfigLoaderTest
    extends GroovyTestCase {

    final def _testConfigPath = new File('').absolutePath + "/src/test/resources/config/"

    @Override
    protected void setUp() {

        if ( System.getProperties().get(ConfigLoader.CONFIG_LOCATION) == null )
        {
            System.getProperties().setProperty(ConfigLoader.CONFIG_LOCATION, _testConfigPath)
        }
    }

    // Load a specific test config file
    void test__loadFromXmlFile_test_location() {

        String testConfigFile = _testConfigPath + "ConfigOne.xml"
        def configLoader = new ConfigLoader()

        def configMap = configLoader.loadFromXmlFile(testConfigFile)
        assertNotNull(configMap)
        assertFalse(configMap.isEmpty())
        assertEquals(15, configMap.size())
    }

    // List all of the config files to load
    void test__loadConfigFiles() {

        def configLoader = new ConfigLoader()
        def configFileNames = configLoader.loadConfigFiles()

        assertNotNull(configFileNames)
        assertEquals(3, configFileNames.size())
    }

    // Load all the test configs into a single depth map
    void test__loadFromXmlFiles() {

        def configLoader = new ConfigLoader()
        def configMap = configLoader.loadFromXmlFiles()

        assertNotNull(configMap)
        assertFalse(configMap.isEmpty())
        assertEquals(35, configMap.size())
    }

    // Load a two deep map with filename as the first level
    void test__loadMapsFromFiles() {

        def configLoader = new ConfigLoader()
        def configMaps = configLoader.loadMapsFromFiles()

        assertNotNull(configMaps)
        assertFalse(configMaps.isEmpty())
        assertEquals(3, configMaps.size())
    }
}
