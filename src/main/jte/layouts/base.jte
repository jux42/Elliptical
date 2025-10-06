@import gg.jte.Content
@param String  title = "Elliptical"
@param String  active = "home"
@param Content content
@param Content sidebar = null

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>${title}</title>
    <style>
        body { font-family: sans-serif; margin: 0; display: flex; min-height: 100vh; }
        .sidebar { width: 200px; background: #f0f0f0; padding: 1rem; }
        .sidebar a { display: block; padding: .5rem; color: #333; text-decoration: none; }
        .sidebar a.active { font-weight: bold; color: darkblue; }
        .content { flex: 1; padding: 2rem; }
    </style>
</head>
<body>

@if (sidebar != null)
    ${sidebar}
@else
    @template.components.sidebar(active = active)
@endif

<section class="content">
    ${content}
</section>

</body>
</html>
