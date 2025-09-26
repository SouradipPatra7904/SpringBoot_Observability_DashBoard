package souradippatra.SpringBoot_Observability_DashBoard.dto;

/**
 * Simple DTO for returning custom metric details
 */
public class MetricResponseDTO {
    private String name;
    private double value;

    public MetricResponseDTO(String name, double value) {
        this.name = name;
        this.value = value;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }
}
