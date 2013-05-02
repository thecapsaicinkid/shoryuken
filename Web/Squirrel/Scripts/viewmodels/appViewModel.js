var sr = sr || {};

sr.AppViewModel = function () {

    // Data
    this.self = this;
    self.reminders = ko.observableArray([]);

    // Operations
    self.addReminder = function () {
        
        self.reminders.push(new Reminder());
    };

    // Perform initial load
    $.getJSON("api/reminder/get", function (allData) {

        var mappedReminders = $.map(allData, function (item) { return new Reminder(item) });
        self.reminders(mappedReminders);
    });
}