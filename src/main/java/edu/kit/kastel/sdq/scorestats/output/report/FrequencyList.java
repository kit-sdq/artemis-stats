package edu.kit.kastel.sdq.scorestats.output.report;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import edu.kit.kastel.sdq.scorestats.cli.ReportOutput;
import edu.kit.kastel.sdq.scorestats.core.report.Report.FrequencyResult;
import edu.kit.kastel.sdq.scorestats.output.Output;
import edu.kit.kastel.sdq.scorestats.output.layout.RightPad;
import edu.kit.kastel.sdq.scorestats.output.ratio.RatioRow;

public abstract class FrequencyList<U> implements Output {

    private final FrequencyResult<U> result;
    private final int itemsCount;
    private final int indentationLevel;

    public FrequencyList(int indentationLevel, FrequencyResult<U> result) {
        this.result = result;
        this.itemsCount = result.values().size();
        this.indentationLevel = indentationLevel;
    }

    public FrequencyList(int indentationLevel, FrequencyResult<U> result, int itemsCount) {
        this.result = result;
        this.itemsCount = itemsCount;
        this.indentationLevel = indentationLevel;
    }

    @Override
    public String print() {
        List<Map.Entry<U, Integer>> items = this.getItems();
        int n = this.result.n();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.itemsCount && i < items.size(); i++) {
            U item = items.get(i).getKey();
            int count = items.get(i).getValue();

            RightPad padding = new RightPad(
                    this.indentationLevel,
                    ReportOutput.COLUMN_WIDTH,
                    new RatioRow(count, n));

            builder.append(padding.print() + this.getLabel(item) + System.lineSeparator());
        }
        return builder.toString();
    }

    private List<Map.Entry<U, Integer>> getItems() {
        List<Map.Entry<U, Integer>> items = new ArrayList<>(this.result.values().entrySet());
        Collections.sort(items, new Comparator<Map.Entry<U, Integer>>() {
            @Override
            public int compare(Map.Entry<U, Integer> o1, Map.Entry<U, Integer> o2) {
                return Integer.compare(o2.getValue(), o1.getValue());
            }
        });
        return items;
    }

    protected abstract String getLabel(U item);

}
