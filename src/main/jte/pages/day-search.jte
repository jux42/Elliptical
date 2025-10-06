@template.layouts.base(
title  = "Find a Day",
active = "days",
content = @`
    <h1>Find a Day</h1>

    <form action="/ui/days/detail" method="get" style="display:flex; gap:0.5rem; align-items:center;">
        <label>Day: <input type="number" name="day" min="1" max="31" required></label>
        <label>Month: <input type="number" name="month" min="1" max="12" required></label>
        <label>Year: <input type="number" name="year" min="2000" max="2100" required></label>
        <button type="submit">Search</button>
    </form>
`
)
