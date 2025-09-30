# SpringBoot_Observability_DashBoard

**An Observability Dashboard implemented in Spring Boot with Micrometer, Prometheus, and PostgreSQL.**

---

## 🚀 Project Vision
This project demonstrates how to build a **real-time observability dashboard** for enterprise applications using **Spring Boot**, **Micrometer**, and **Prometheus**.  
It combines:  

- **Custom Metrics** (Counters, Timers, Gauges)  
- **Database Health Monitoring** (PostgreSQL)  
- **REST API Endpoints** for real-time metric updates  
- **Prometheus Integration** for metric scraping  
- **Grafana Dashboard** for visualization  

This makes it a compact yet **enterprise-ready observability showcase**.

---

## ⚙️ Tech Stack
- **Java 21**  
- **Spring Boot 3.5.6**  
- **Micrometer**  
- **Prometheus**  
- **PostgreSQL**  
- **Maven (Jar packaging)**  

---

## Running the Application
1. Configure PostgreSQL in `application.properties`:

```properties
server.port=9595

spring.datasource.url=jdbc:postgresql://localhost:5432/observabilitydb
spring.datasource.username=observabilityuser
spring.datasource.password=observabilitypass
spring.jpa.hibernate.ddl-auto=update

# Actuator & Prometheus
management.endpoints.web.exposure.include=health,info,metrics,prometheus
management.endpoint.prometheus.access=UNRESTRICTED
management.endpoint.health.show-details=always

# Logging & Tracing
logging.level.org.springframework=info
logging.level.souradippatra.SpringBoot_Observability_DashBoard=debug
management.tracing.sampling.probability=1.0
management.otlp.tracing.endpoint=http://localhost:7075
```

2. Build & Run:

```bash
mvn clean package
java -jar target/SpringBoot_Observability_DashBoard-0.0.1-SNAPSHOT.jar
```

3. Application runs on [http://localhost:9595](http://localhost:9595)

---

## 🎯 Key Highlights
- Unified **Health Indicator** combining DB health, custom metrics, and active users  
- **Real-time metrics**: custom counters, timers, and gauges  
- **Prometheus endpoint** for scraping metrics  
- **Grafana dashboard** displaying counters, active users, DB health, and request latency (p50/p95/p99)  
- Fully **enterprise-ready and recruiter-friendly**  

---

## 🏗️ Future Enhancements
- Add **distributed tracing** visualization via Jaeger / OpenTelemetry  
- Support **multi-database monitoring** (PostgreSQL + others)  
- Introduce **alerting & threshold notifications** in Grafana  
- Extend **dashboard with advanced metrics**: error rates, throughput, SLA compliance  
- Add **role-based access** for metrics and dashboards
