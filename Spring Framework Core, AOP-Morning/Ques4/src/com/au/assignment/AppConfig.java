package com.au.assignment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name="rectangleObj")
    public Rectangle getRectangle() {
        return new Rectangle(10,30);
    }

    @Bean(name="pointA")
    public Point getPointA() {
        return new Point(0,0);
    }

    @Bean(name="pointB")
    public Point getPointB() {
        return new Point(10,0);
    }

    @Bean(name="pointC")
    public Point getPointC() {
        return new Point(0,30);
    }

    @Bean(name="pointD")
    public Point getPointD() {
        return new Point(10,30);
    }
}
