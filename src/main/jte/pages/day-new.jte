@import com.jux42.elliptical.web.form.DayForm
@import org.springframework.validation.ObjectError
@param DayForm form
@param java.util.List<ObjectError> errors = null
@param String message = null

@template.layouts.base(
title  = "Create Day",
active = "days",
content = @`
    <h1>Create a Day</h1>

    @if (message != null)
        <p style="background:#e6ffe6;border:1px solid #b2e6b2;padding:.5rem;">${message}</p>
    @endif

    @if (errors != null && !errors.isEmpty())
        <ul style="color:#b00020;">
            @for (ObjectError err : errors)
                <li>${err.getDefaultMessage()}</li>
            @endfor
        </ul>
    @endif

    <form action="/ui/days" method="post" style="display:grid;gap:.75rem;max-width:420px;">
        <label>Date
            <input type="date" name="date" value="${form.getDate().toString()}">
        </label>

        <div style="display:flex;gap:.5rem;">
            <label>Minutes
                <input type="number" name="minutes" min="0" required value="${form.getMinutes() == null ? "" : form.getMinutes().toString()}">
            </label>
            <label>Seconds
                <input type="number" name="seconds" min="0" max="59" required value="${form.getSeconds() == null ? "" : form.getSeconds().toString()}">
            </label>
        </div>

        <label>Distance (km)
            <input type="number" step="0.01" name="distance" value="${form.getDistance() == null ? "" : form.getDistance().toString()}">
        </label>

        <div style="display:flex;gap:.5rem;">
            <label>Max force
                <input type="number" min="0" name="maxForce" value="${form.getMaxForce() == null ? "" : form.getMaxForce().toString()}">
            </label>
            <label>Min force
                <input type="number" min="0" name="minForce" value="${form.getMinForce() == null ? "" : form.getMinForce().toString()}">
            </label>
        </div>

        <label>Calories
            <input type="number" min="0" name="calories" value="${form.getCalories() == null ? "" : form.getCalories().toString()}">
        </label>

        <button type="submit">Create</button>
        <a href="/ui/days">Cancel</a>
    </form>
`
)
