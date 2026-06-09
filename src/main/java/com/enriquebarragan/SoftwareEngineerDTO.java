package com.enriquebarragan;

import lombok.Builder;

import java.util.List;

@Builder
public record SoftwareEngineerDTO (String name, List<String> techStack) {
}
