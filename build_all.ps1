$services = Get-ChildItem -Path .\services\ -Directory

foreach ($service in $services) {
    Write-Host "Building $($service.Name)..."
    Set-Location $service.FullName
    mvn clean install -D skipTests
    Set-Location ../..
}

docker compose build