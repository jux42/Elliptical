@param com.jux42.elliptical.web.view.DayView day

@template.layouts.base(
title  = "Day Detail",
active = "days",
content = @`
    <h1>Day Detail</h1>
    <ul>
        <li><strong>Date:</strong> ${day.date().toString()}</li>
        <li><strong>Duration:</strong> ${day.friendlyDuration()}</li>
        <li><strong>Distance:</strong> ${day.distance()}</li>
        <li><strong>Calories:</strong> ${day.calories()}</li>
        <li><strong>Performance:</strong> ${day.performance()}</li>
    </ul>
    <a href="/ui/search">🔙 Back to search</a>
`
)
