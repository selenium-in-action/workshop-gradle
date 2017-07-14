# Check if there are updates for dependencies
`gradle dependencyUpdates -Drevision=release`


# Run specific test groups
Defaults to `lineair` (first training)
`gradle test -Ptraining=lineair`

If you want to switch to `structured` (second training)
`gradle test -Ptraining=structured`

# Report

open `build/reports/tests/test/html/index.html`