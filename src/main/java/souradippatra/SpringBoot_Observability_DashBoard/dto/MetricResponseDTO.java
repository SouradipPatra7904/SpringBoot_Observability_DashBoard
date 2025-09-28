package souradippatra.SpringBoot_Observability_DashBoard.dto;

/**
 * Simple DTO for returning custom metric details
 */
public class MetricResponseDTO {
    private String name;
    private double counter;

    public MetricResponseDTO(String name, double counter) {
        this.name = name;
        this.counter = counter;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getCounter() {
        return counter;
    }
}
