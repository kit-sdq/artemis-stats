package edu.kit.kastel.sdq.scorestats.core.report.visitors;

import java.util.Collection;
import java.util.stream.Collectors;

import edu.kit.kastel.sdq.artemis4j.api.grading.IMistakeType;
import edu.kit.kastel.sdq.scorestats.core.report.Report.ReportData;
import edu.kit.kastel.sdq.scorestats.core.assessment.Assessment;
import edu.kit.kastel.sdq.scorestats.core.report.ReportFrequencyVisitor;

public class AnnotationFrequencyPerAnnotation<K> implements ReportFrequencyVisitor<K, Assessment<K>, IMistakeType> {

    @Override
    public Iterable<Assessment<K>> iterable(ReportData<K> data) {
        return data.selectedAssessments();
    }

    @Override
    public Collection<IMistakeType> count(Assessment<K> value) {
        return value.getAnnotations().stream()
                .map(annotation -> annotation.getMistakeType())
                .collect(Collectors.toList());
    }

    @Override
    public int n(ReportData<K> data) {
        int sum = 0;
        for (Assessment<K> assessment : data.selectedAssessments()) {
            sum += assessment.getAnnotations().size();
        }
        return sum;
    }

}
