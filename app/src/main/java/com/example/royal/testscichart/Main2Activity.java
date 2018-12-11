package com.example.royal.testscichart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.scichart.charting.model.dataSeries.XyDataSeries;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.IAxis;
import com.scichart.charting.visuals.renderableSeries.FastColumnRenderableSeries;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.core.utility.ISciChartDebugLoggerFacade;
import com.scichart.core.utility.SciChartDebugLogger;
import com.scichart.data.model.DoubleRange;
import com.scichart.drawing.utility.ColorUtil;
import com.scichart.extensions.builders.SciChartBuilder;

import java.util.Collections;

public class Main2Activity extends AppCompatActivity {

    private IAxis xAxis, yAxis;
    private FastColumnRenderableSeries rs;

    SciChartSurface surface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SciChartBuilder.init(Main2Activity.this);
        surface = (SciChartSurface) findViewById(R.id.surface);

        // Obtain the SciChartBuilder instance
        final SciChartBuilder sciChartBuilder = SciChartBuilder.instance();

        xAxis = sciChartBuilder.newNumericAxis().withGrowBy(new DoubleRange(0.1d, 0.1d)).build();
        yAxis = sciChartBuilder.newNumericAxis().withGrowBy(new DoubleRange(0.1d, 0.1d)).build();

        final XyDataSeries<Double, Double> dataSeries = new XyDataSeries<>(Double.class, Double.class);
        dataSeries.append(new Double[]{0d, 2d, 4d, 6d, 8d, 10d}, new Double[]{1d, 5d, -5d, -10d, 10d, 3d});

        rs = sciChartBuilder.newColumnSeries()
                .withDataSeries(dataSeries)
                .withStrokeStyle(ColorUtil.White, 3f, false)
                .build();

        surface.getChartModifiers().add(sciChartBuilder.newModifierGroupWithDefaultModifiers().build());

        UpdateSuspender.using(surface, new Runnable() {
            @Override
            public void run() {
                Collections.addAll(surface.getXAxes(), xAxis);
                Collections.addAll(surface.getYAxes(), yAxis);
                Collections.addAll(surface.getRenderableSeries(), rs);

                //sciChartBuilder.newAnimator(rs).withWaveTransformation(0f ,1500).start();
            }
        });


        SciChartDebugLogger.instance().setLoggerFacade(new ISciChartDebugLoggerFacade() {
            @Override
            public void logInfo(String tag, String stringFormat, Object... args) {
                Log.e("tag info", args.toString());
            }

            @Override
            public void logWarning(String tag, String stringFormat, Object... args) {
                Log.e("tag warning", args.toString());

            }

            @Override
            public void logError(String tag, String stringFormat, Object... args) {
                Log.e("tag error", args.toString());

            }

            @Override
            public void handleException(String tag, Exception exception) {
                Log.e("tag exception", exception.toString());

            }
        });

    }
}