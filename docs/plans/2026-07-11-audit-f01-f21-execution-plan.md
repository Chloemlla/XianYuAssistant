# XianYuAssistant F01–F21 Governed Execution Plan

## Internal Grade

XL. The work spans backend concurrency/security, frontend lifecycle/accessibility, data integrity, release packaging, tests, and documentation. Waves are sequential; independent file ownership may run in parallel within a wave.

## Wave 1 — Inventory and Contracts

- Map each finding to current code, existing abstractions, and precise acceptance checks.
- Freeze shared executor, bootstrap auth, delivery claim, polling, dialog, and test strategies before editing.
- Ownership: backend runtime/security; frontend state/a11y; release/tests/docs.

## Wave 2 — Security and Integrity

- Implement F01, F02, F08, F12–F14, and the privacy portion of F21.
- Add focused backend/frontend tests and configuration validation.
- Rollback: changes remain isolated by concern; revert individual focused files/classes if an API contract proves incompatible.

## Wave 3 — Capacity and State Correctness

- Implement F03–F07, F15–F19, and AI budgets from F21.
- Prefer shared bounded executors and small frontend primitives/composables; do not expand existing large files unnecessarily.
- Rollback: retain old public API shapes where possible; internal scheduling and merge behavior may be reverted independently.

## Wave 4 — Release Authenticity

- Implement F09, F10, and F20: Docker artifact order/runtime dependencies, CI gates, version/channel/doc alignment.
- Add workflow-only commands for backend and frontend verification.

## Verification

- Local: read-only/static review only (`git diff`, targeted searches, YAML/JSON inspection). No build or test execution.
- Remote: push delivery commit; inspect GitHub Actions jobs for backend tests, frontend type/lint/unit tests, packaging checks, and existing docs/build gates.
- Spot checks encoded as tests: bootstrap registration lifecycle, sensitive-log sentinels, backup partial failure, request ordering, history merge/scroll, responsive route preservation, dialog keyboard behavior, progress expiry, AI limits, and release artifact assertions.

## Completion Language

- Full completion requires all F01–F21 mapped to code changes and remote workflow success.
- If a workflow or external service blocks validation, report implemented scope and exact unverified evidence; do not claim stable-release readiness.

## Phase Cleanup

- Remove temporary diagnostics and generated scratch files.
- Audit live child agents and stop/close residual work.
- Record cleanup and delivery-acceptance receipts under `outputs/runtime/vibe-sessions/20260711-audit-f01-f21-remediation/`.
- Commit with generated message and push to the active remote branch.
