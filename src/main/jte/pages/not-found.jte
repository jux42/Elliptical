@template.layouts.base(
title  = "Day not found",
active = "days",
content = @`
    <h1>No session found for this date</h1>
    <p>Try again with another date.</p>
    <a href="/ui/days/search">🔙 Back to search</a>
`
)
