package steps;

import io.cucumber.java.DataTableType;
import model.ComputeEngineInstance;

import java.util.Map;

public class DataTableConfigurer {
    @DataTableType
    public ComputeEngineInstance instanceEntry(Map<String, String> entry) {
        return new ComputeEngineInstance(
                entry.get("numberOfInstances"),
                entry.get("operatingSystem"),
                entry.get("provisioningModel"),
                entry.get("machineFamily"),
                entry.get("series"),
                entry.get("machineType"),
                entry.get("gpuType"),
                entry.get("gpuNumber"),
                entry.get("localSSD"),
                entry.get("region"),
                entry.get("discountOptions")
        );
    }
}
