@param String active = "home"

<aside class="sidebar">
    <nav>
        <ul>
            <li><a href="/ui/days/new" class="${active.equals("days") ? "active" : ""}">➕ New Day</a></li>
            <li><a href="/ui/days/all" class="${active.equals("all") ? "active" : ""}">📅 Days</a></li>
            <li><a href="/ui/dashboard" class="${active.equals("home") ? "active" : ""}">🏠 Dashboard</a></li>
            <li><a href="/ui/stats" class="${active.equals("stats") ? "active" : ""}">📊 Stats</a></li>
            <li><a href="/ui/days/search" class="${active.equals("search") ? "active" : ""}">📅 Search</a></li>
            <li><a href="/ui/settings" class="${active.equals("settings") ? "active" : ""}">⚙️ Settings</a></li>
        </ul>
    </nav>
</aside>
