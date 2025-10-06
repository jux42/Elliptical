@param java.util.List<com.jux42.elliptical.web.view.DayView> days


@template.layouts.base(
title  = "Elliptical - Days",
active = "home",
content = @`
    <h1>Days</h1>
    @if (days.isEmpty())
        <p>No sessions yet.</p>
    @else
        <table style="border-collapse:collapse;width:100%">
            <thead>
            <tr>
                <th style="text-align:left;border-bottom:1px solid #ccc;padding:.5rem">Date</th>
                <th style="text-align:left;border-bottom:1px solid #ccc;padding:.5rem">Duration</th>
                <th style="text-align:left;border-bottom:1px solid #ccc;padding:.5rem">Distance (km)</th>
                <th style="text-align:left;border-bottom:1px solid #ccc;padding:.5rem">Calories</th>
                <th style="text-align:left;border-bottom:1px solid #ccc;padding:.5rem">Performance</th>
            </tr>
            </thead>
            <tbody>
            @for (com.jux42.elliptical.web.view.DayView day : days)
                <tr>
                    <td style="padding:.5rem">${day.date().toString()}</td>
                    <td style="padding:.5rem">${day.friendlyDuration()}</td>
                    <td style="padding:.5rem">${day.distance() == null ? "-" : day.distance().toString()}</td>
                    <td style="padding:.5rem">${day.calories() == null ? "-" : day.calories().toString()}</td>
                    <td style="padding:.5rem">${day.performance() == null ? "-" : day.performance().toString()}</td>
                </tr>
            @endfor
            </tbody>
        </table>
    @endif
`
)
