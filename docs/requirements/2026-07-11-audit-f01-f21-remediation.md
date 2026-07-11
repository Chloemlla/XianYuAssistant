# XianYuAssistant F01–F21 Remediation Requirements

## Goal

Implement every remediation item F01 through F21 in `docs/audit-report-xianyuassistant-2026-07-11.md` so security, runtime capacity, frontend state correctness, backup integrity, CI authenticity, release packaging, documentation, and AI safeguards are materially improved.

## Deliverables

- Backend fixes for F01–F05, F08, F12–F13, F19, and F21.
- Frontend fixes for F06–F07, F11, and F13–F18.
- Docker, workflow, test, version, installation, and documentation fixes for F09–F10 and F20.
- Automated regression coverage committed to the repository and executed only by GitHub Actions.
- A pushed commit on the active branch, with the resulting workflow run inspected before completion is claimed.

## Constraints

- Do not run Maven, npm build/test/type-check/lint, Flutter, Gradle, Docker builds, or application tests locally.
- All actual build and test commands run in GitHub Actions.
- Preserve unrelated user work, including the supplied audit report.
- Avoid new oversized multipurpose files; add focused classes, composables, and components.
- Use UTF-8 when reading repository text.
- GPG signing may be omitted for the delivery commit.

## Acceptance Criteria

1. No access token, Cookie header, raw chat text, AI prompt, or response body is emitted to normal application/browser logs.
2. First-user registration requires deployment-controlled bootstrap authorization and becomes permanently unavailable after initialization.
3. Scheduled token refresh, API delivery, WebSocket processing, confirmation, and QR polling use bounded shared execution without scheduler sleeps or unmanaged threads; delivery has durable claim/idempotency behavior.
4. A single routed page instance survives responsive breakpoint changes.
5. Message history and live updates merge without deleting loaded history; polling is single-flight, visibility-aware, and does not force-scroll readers.
6. Backup import reports record/module failures truthfully, validates input, and sensitive exports are protected or explicitly excluded by default.
7. Docker uses the current frontend artifact and includes required Playwright runtime support.
8. GitHub Actions fails on absent backend tests, runs backend tests against MongoDB, and runs frontend type-check, lint, and component/unit tests.
9. Login/registration errors, list errors, retries, stale-data timestamps, request races, dialogs, icon buttons, labels, focus, and keyboard behavior have explicit UI handling.
10. JWT secrets are externally supplied and validated; password changes revoke active tokens; access lifetime is reduced with refresh support.
11. Sync progress has thread-safe visibility, bounded retention, and cleanup.
12. GHCR is the documented canonical image channel; versions and MongoDB architecture/configuration documentation agree.
13. AI requests have prompt-size, concurrency, timeout, and output-budget controls with metadata-only logging.
14. GitHub Actions for the delivery commit completes successfully, or any remaining external failure is reported precisely without a false completion claim.

## Non-goals

- Whole-product visual redesign.
- Introduction of a large global frontend state framework.
- Local execution of resource-intensive build/test commands.

## Autonomy and Delivery Truth

The agent may make implementation choices inside the audited scope without further confirmation. “全部修复完成” is allowed only after code review plus successful remote workflow evidence; otherwise the final language must identify unverified or externally blocked items.
